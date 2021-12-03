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

import java.text.MessageFormat;
import org.cactoos.Text;

public class SeparateDataFileLineOfRow implements Text {

    private final Row row;

    private final Iterable<Column> cols;

    public SeparateDataFileLineOfRow(final Row row, final Iterable<Column> cols) {
        this.row = row;
        this.cols = cols;
    }

    @Override
    public String asString() {
        return MessageFormat.format(
            "{0}: [{1}]",
            this.row.label(),
            String.join(
                ", ",
                new StorableFormattedValuesOfRow(row, cols)
            )
        );
    }

}
