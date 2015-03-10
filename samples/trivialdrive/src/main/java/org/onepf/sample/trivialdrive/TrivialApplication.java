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

package org.onepf.sample.trivialdrive;

import android.app.Application;

import org.onepf.opfiab.OPFIab;
import org.onepf.opfiab.amazon.AmazonBillingProvider;
import org.onepf.opfiab.billing.BillingProvider;
import org.onepf.opfiab.google.GoogleBillingProvider;
import org.onepf.opfiab.listener.SimpleGlobalBillingListener;
import org.onepf.opfiab.model.Configuration;
import org.onepf.opfutils.OPFLog;


public class TrivialApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        OPFLog.setEnabled(true);
        final Configuration configuration = new Configuration.Builder()
                .addBillingProvider(newGoogleBillingProvider())
                .addBillingProvider(newAmazonBillingProvider())
                .setBillingListener(new SimpleGlobalBillingListener())
                .build();
        OPFIab.init(this, configuration);
        OPFIab.setup();
    }

    private BillingProvider newGoogleBillingProvider() {
        return new GoogleBillingProvider.Builder(this)
                .build();
    }

    private BillingProvider newAmazonBillingProvider() {
        return new AmazonBillingProvider.Builder(this)
                .build();
    }
}
