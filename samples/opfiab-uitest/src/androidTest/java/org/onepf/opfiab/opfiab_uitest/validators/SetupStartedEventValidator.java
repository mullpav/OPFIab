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

package org.onepf.opfiab.opfiab_uitest.validators;

import org.onepf.opfiab.model.event.SetupStartedEvent;

/**
 * @author antonpp
 * @since 25.05.15
 */
public class SetupStartedEventValidator extends TypedEventValidator<SetupStartedEvent> {

    public SetupStartedEventValidator() {
        super(SetupStartedEvent.class);
    }

    @Override
    public boolean validate(Object event, final boolean isLogging, final String logTag) {
        return super.validate(event, isLogging, logTag);
    }
}
