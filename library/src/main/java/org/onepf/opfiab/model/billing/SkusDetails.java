/*
 * Copyright 2012-2014 One Platform Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onepf.opfiab.model.billing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Created by rzhilich on 12/5/14.
 */
public class SkusDetails extends BillingModel {

    @NonNull
    private final List<SkuDetails> detailsList;

    public SkusDetails(@NonNull final List<SkuDetails> detailsList, @Nullable final Bundle source) {
        super(source);
        this.detailsList = Collections.unmodifiableList(detailsList);
    }

    @NonNull
    public List<SkuDetails> getDetailsList() {
        return detailsList;
    }
}
