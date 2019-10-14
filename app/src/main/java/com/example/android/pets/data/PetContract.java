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
package com.example.android.pets.data;

import android.net.Uri;
import android.content.ContentResolver;
import android.provider.BaseColumns;

/**
 * API Contract for the Pets app.
 */
public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {
    }

    static final String CONTENT_AUTHORITY = "com.example.android.pets";
    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    static final String PATH_PETS = "pets";

    public static final class PetEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);
        static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;
        static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        // Table Pets
        final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        // Gender
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        static boolean isValidGender(int gender) {
            return gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE;
        }
    }

}

