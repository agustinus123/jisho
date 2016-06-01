package net.fauxpark.jisho.mapper;

import android.database.Cursor;

import net.fauxpark.jisho.model.Radical;

public class RadicalMapper {
    private static final String ID = "id";

    private static final String LITERAL = "literal";

    private static final String NAME = "name";

    private static final String READING = "reading";

    private static final String STROKE_COUNT = "stroke_count";

    private static final String VARIANTS = "variants";

    public static Radical map(Cursor cursor) {
        Radical radical = new Radical();

        radical.setId(cursor.getInt(cursor.getColumnIndex(ID)));
        radical.setLiteral(cursor.getString(cursor.getColumnIndex(LITERAL)));
        radical.setName(cursor.getString(cursor.getColumnIndex(NAME)));
        radical.setReading(cursor.getString(cursor.getColumnIndex(READING)));
        radical.setStrokeCount(cursor.getInt(cursor.getColumnIndex(STROKE_COUNT)));
        radical.setVariants(cursor.getString(cursor.getColumnIndex(VARIANTS)));

        return radical;
    }
}
