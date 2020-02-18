/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetCursorAdapter extends CursorAdapter {

    PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_pets, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView petNameTextView = view.findViewById(R.id.pet_name);
        TextView petBreedTextView = view.findViewById(R.id.pet_breed);

        int petNameColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME);
        int petBreedColumnIndex = cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED);

        String petName = cursor.getString(petNameColumnIndex);
        String petBreed = cursor.getString(petBreedColumnIndex);

        if (TextUtils.isEmpty(petBreed)) {
            petBreed = context.getString(R.string.unknown_breed);
        }

        petNameTextView.setText(petName);
        petBreedTextView.setText(petBreed);
    }
}
