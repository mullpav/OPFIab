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

package org.onepf.opfiab.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.onepf.opfiab.BaseBillingProvider;
import org.onepf.opfiab.model.BillingProviderInfo;
import org.onepf.opfiab.model.billing.Purchase;
import org.onepf.opfiab.sku.SkuResolver;
import org.onepf.opfiab.verification.PurchaseVerifier;
import org.onepf.opfutils.OPFLog;

import java.util.Set;

public class GoogleBillingProvider extends BaseBillingProvider {

    private static final String NAME = "Google";
    private static final String PACKAGE_NAME = "com.google.play";
    private static final String PERMISSION_BILLING = "com.android.vending.BILLING";


    private final BillingProviderInfo info = new BillingProviderInfo(NAME, PACKAGE_NAME);
    private final GoogleBillingHelper helper;

    protected GoogleBillingProvider(
            @NonNull final Context context,
            @NonNull final PurchaseVerifier purchaseVerifier,
            @NonNull final SkuResolver skuResolver) {
        super(context, purchaseVerifier, skuResolver);
        checkRequirements();
        helper = new GoogleBillingHelper(context);
    }

    private void checkRequirements() {
        context.enforceCallingOrSelfPermission(PERMISSION_BILLING, null);
    }

    @Override
    public boolean isAvailable() {
        final Response response = helper.isBillingSupported();
        OPFLog.d("Check if billing supported: %s", response);
        return response == Response.OK;
    }

    @NonNull
    @Override
    public BillingProviderInfo getInfo() {
        return info;
    }

    @Override
    public void purchase(@NonNull final Activity activity, @NonNull final String sku) {

    }

    @Override
    public void consume(@NonNull final Purchase purchase) {

    }

    @Override
    public void skuDetails(@NonNull final Set<String> skus) {

    }

    @Override
    public void inventory(final boolean startOver) {

    }

    @Override
    public void onActivityResult(@NonNull final Activity activity, final int requestCode,
                                 final int resultCode, @Nullable final Intent data) {

    }


    public static class Builder extends BaseBillingProvider.Builder {

        public Builder(@NonNull final Context context) {
            super(context);
        }

        @Override
        public GoogleBillingProvider build() {
            return new GoogleBillingProvider(context, purchaseVerifier, skuResolver);
        }

        public Builder purchaseVerifier(@NonNull final PurchaseVerifier purchaseVerifier) {
            super.setPurchaseVerifier(purchaseVerifier);
            return this;
        }

        @Override
        public Builder setSkuResolver(@NonNull final SkuResolver skuResolver) {
            super.setSkuResolver(skuResolver);
            return this;
        }
    }
}
