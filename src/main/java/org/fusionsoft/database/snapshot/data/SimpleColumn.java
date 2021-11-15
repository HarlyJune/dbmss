/*
 * Copyright (C) 2018-2021 FusionSoft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.fusionsoft.database.snapshot.data;

import org.cactoos.Text;

public class SimpleColumn implements Column {

    private final Text text;

    private final Number number;

    private final ValueFormat tformat;

    public SimpleColumn(final Text name, final Number order, final ValueFormat format) {
        this.text = name;
        this.number = order;
        this.tformat = format;
    }

    @Override
    public Text name() {
        return this.text;
    }

    @Override
    public Number order() {
        return this.number;
    }

    @Override
    public ValueFormat format() {
        return this.tformat;
    }

}
