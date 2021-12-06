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
package org.fusionsoft.database.mapping.dbd.ofobjects;

import com.amihaiemil.eoyaml.YamlMapping;
import org.fusionsoft.database.mapping.MappingOfRepresentative;
import org.fusionsoft.database.mapping.dbd.DbdColumnMapping;
import org.fusionsoft.database.mapping.dbd.DbdTableMapping;
import org.fusionsoft.database.mapping.fields.DbdTableFields;
import org.fusionsoft.database.snapshot.DbObject;
import org.fusionsoft.lib.yaml.YamlNodeOfPath;
import org.fusionsoft.lib.yaml.artefacts.IterableOfYamlSequence;

/**
 * The {@link Iterable} of {@link DbdColumnMapping},
 *  constructed of artifacts with {@link DbdTableMapping}.
 * @since 0.1
 */
public class DbdColumnMappingsOfTable extends IterableOfYamlSequence<DbdColumnMapping> {

    /**
     * Instantiates a new Dbd column mappings of table.
     * @param object The {@link DbObject} of {@link DbdTableMapping} to be encapsulated.
     */
    public DbdColumnMappingsOfTable(final DbObject<DbdTableMapping> object) {
        this(new MappingOfRepresentative(object));
    }

    /**
     * Instantiates a new Dbd column mappings of table.
     * @param mapping The {@link YamlMapping} to be encapsulated.
     */
    private DbdColumnMappingsOfTable(final YamlMapping mapping) {
        this(new DbdTableMapping(mapping));
    }

    /**
     * Instantiates a new Dbd column mappings of table.
     * @param mapping The {@link DbdTableMapping} to be encapsulated.
     */
    public DbdColumnMappingsOfTable(final DbdTableMapping mapping) {
        super(
            new YamlNodeOfPath(mapping, DbdTableFields.COLUMNS),
            x -> new DbdColumnMapping(x.asMapping())
        );
    }

}
