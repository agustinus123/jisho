package net.fauxpark.jisho.task;

import java.io.File;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import net.fauxpark.jisho.R;
import net.fauxpark.jisho.util.DatabaseUtil;

public class UnzipTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "UnzipTask";

    private Context context;

    private String path;

    private ProgressDialog progressDialog;

    public UnzipTask(Context context) {
        this.context = context;
        this.path = DatabaseUtil.getDatabasePath(context);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        setupProgressDialog();
    }

    @Override
    protected Void doInBackground(Void... params) {
        DatabaseUtil.makeDirs(path);

        try {
            ZipInputStream zipInputStream = new ZipInputStream(context.getAssets().open("jisho.zip"));
            byte[] buffer = new byte[2048];
            int length;
            ZipEntry zipEntry;

            while((zipEntry = zipInputStream.getNextEntry()) != null) {
                if(new File(path + zipEntry.getName()).exists()) {
                    Log.d(TAG, zipEntry.getName() + " already exists, skipping");

                    continue;
                }

                Log.d(TAG, "Unzipping " + zipEntry.getName() + "...");

                FileOutputStream fileOutputStream = new FileOutputStream(path + zipEntry.getName());

                while((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }

                zipInputStream.closeEntry();
                fileOutputStream.close();
            }

            zipInputStream.close();
        } catch(Exception e) {
            Log.d(TAG, "Unzip failed", e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        progressDialog.dismiss();
    }

    private void setupProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle(R.string.unzipDialogTitle);
        progressDialog.setMessage(context.getResources().getString(R.string.unzipDialogProgress));
        progressDialog.show();
    }
}
