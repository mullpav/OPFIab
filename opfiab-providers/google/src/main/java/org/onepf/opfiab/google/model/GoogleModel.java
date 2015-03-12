/*
 * Copyright 2012-2015 One Platform Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onepf.opfiab.google.model;

import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

abstract class GoogleModel {

    private static final String NAME_PRODUCT_ID = "productId";
    private static final String NAME_TYPE = "itemType";


    @NonNull
    private final String originalJson;
    @NonNull
    private final String productId;
    @NonNull
    private final ItemType itemType;

    protected GoogleModel(@NonNull final JSONObject json) throws JSONException {
        super();
        this.originalJson = json.toString();
        this.productId = json.getString(NAME_PRODUCT_ID);

        final String itemTypeCode = json.getString(NAME_TYPE);
        final ItemType itemType = ItemType.fromCode(itemTypeCode);
        if (itemType == null) {
            throw new JSONException("Unrecognized itemType: " + itemTypeCode);
        }
        this.itemType = itemType;
    }

    @NonNull
    public String getOriginalJson() {
        return originalJson;
    }

    @NonNull
    public ItemType getItemType() {
        return itemType;
    }

    @NonNull
    public String getProductId() {
        return productId;
    }
}