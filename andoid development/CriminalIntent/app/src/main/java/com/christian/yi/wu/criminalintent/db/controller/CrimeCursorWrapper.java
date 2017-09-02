package com.christian.yi.wu.criminalintent.db.controller;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.christian.yi.wu.criminalintent.db.model.CrimeDbSchema;
import com.christian.yi.wu.criminalintent.model.Crime;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2017/9/1.
 */

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SOLVED));
        String suspect = getString(getColumnIndex(CrimeDbSchema.CrimeTable.Cols.SUSPECT));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setSolved(isSolved != 0);
        crime.setDate(new Date(date));
        crime.setSuspect(suspect);
        return crime;
    }
}
