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

import java.sql.Connection;
import org.fusionsoft.database.mapping.dbd.DbdDataMapping;
import org.fusionsoft.database.mapping.dbd.DbdTableMapping;
import org.fusionsoft.database.mapping.fields.DbdTableFields;
import org.fusionsoft.database.snapshot.DbObject;
import org.fusionsoft.database.snapshot.objects.ObjectType;
import org.fusionsoft.database.snapshot.objects.SimpleDbObject;
import org.fusionsoft.database.snapshot.objectsignature.SimpleObjectNameOfValues;
import org.fusionsoft.database.snapshot.objectsignature.SimpleObjectSignature;
import org.fusionsoft.lib.yaml.YamlMappingOfEntries;

public class InlineDataObjectOfTable extends SimpleDbObject<DbdDataMapping> {

    /**
     * Instantiates a new simple db object.
     */
    public InlineDataObjectOfTable(
        final DbObject<DbdTableMapping> table,
        final Connection connection
    ) {
        super(
            new DbdDataMapping(
                new YamlMappingOfEntries(
                    new DbdDataEntriesOfTable(
                        connection,
                        table
                    )
                )
            ),
            new SimpleObjectSignature(
                new SimpleObjectNameOfValues(
                    table.signature().name().parent(),
                    table.signature().name().first(),
                    DbdTableFields.DATA
                ),
                ObjectType.DATA
            )
        );
    }

}
