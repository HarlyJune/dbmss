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

import com.amihaiemil.eoyaml.YamlNode;
import java.util.Map;
import org.cactoos.Text;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.map.MapEntry;
import org.fusionsoft.database.mapping.dbd.DbdConstraintMapping;
import org.fusionsoft.database.mapping.dbd.DbdDataMapping;
import org.fusionsoft.database.mapping.dbd.DbdIndexMapping;
import org.fusionsoft.database.mapping.dbd.DbdTableMapping;
import org.fusionsoft.database.mapping.dbd.DbdTriggerMapping;
import org.fusionsoft.database.mapping.entries.EntriesWithKeys;
import org.fusionsoft.database.mapping.entries.EntriesWithoutKeys;
import org.fusionsoft.database.mapping.fields.DbdTableFields;
import org.fusionsoft.lib.collection.SingleOrEmptyFallback;
import org.fusionsoft.lib.yaml.EntriesOfYamlMapping;
import org.fusionsoft.lib.yaml.MappingEmpty;
import org.fusionsoft.lib.yaml.MappingWithoutNullScalars;
import org.fusionsoft.lib.yaml.YamlMappingOfEntries;
import org.fusionsoft.lib.yaml.YamlMappingOfScalar;

/**
 * The DBD/sequences/#sequence/tables/#table node mapping.
 * @since 0.1
 * @checkstyle ClassDataAbstractionCouplingCheck (100 lines)
 */
public class DbdTableMappingOfEntries extends DbdTableMapping {

    /**
     * Instantiates a new Dbd table mapping of entries.
     * @param table The table DbObject entry to take data from.
     * @param indexes The Iterable of Text -> {@link DbdIndexMapping}
     *  entries to be encapsulated.
     * @param constraints The Iterable of Text -> {@link DbdConstraintMapping}
     *  entries to be encapsulated.
     * @param triggers The Iterable of Text -> {@link DbdTriggerMapping}
     *  entries to be encapsulated.
     * @checkstyle ParameterNumberCheck (100 lines)
     */
    public DbdTableMappingOfEntries(
        final DbdTableMapping table,
        final Iterable<? extends Map.Entry<Text, DbdIndexMapping>> indexes,
        final Iterable<? extends Map.Entry<Text, DbdConstraintMapping>> constraints,
        final Iterable<? extends Map.Entry<Text, DbdTriggerMapping>> triggers
    ) {
        this(
            table,
            indexes,
            new IterableOf<>(),
            constraints,
            triggers
        );
    }

    /**
     * Instantiates a new Dbd table mapping of entries.
     * @param table The table DbObject entry to take data from.
     * @param indexes The Iterable of Text -> {@link DbdIndexMapping}
     *  entries to be encapsulated.
     * @param data The Iterable of Text -> {@link DbdDataMapping}
     *  entries to be encapsulated.
     * @param constraints The Iterable of Text -> {@link DbdConstraintMapping}
     *  entries to be encapsulated.
     * @param triggers The Iterable of Text -> {@link DbdTriggerMapping}
     *  entries to be encapsulated.
     * @checkstyle ParameterNumberCheck (100 lines)
     */
    public DbdTableMappingOfEntries(
        final DbdTableMapping table,
        final Iterable<? extends Map.Entry<Text, DbdIndexMapping>> indexes,
        final Iterable<? extends Map.Entry<Text, DbdDataMapping>> data,
        final Iterable<? extends Map.Entry<Text, DbdConstraintMapping>> constraints,
        final Iterable<? extends Map.Entry<Text, DbdTriggerMapping>> triggers
    ) {
        super(
            new MappingWithoutNullScalars(
                new YamlMappingOfEntries(
                    new Joined<>(
                        new EntriesWithoutKeys(
                            new EntriesOfYamlMapping(table),
                            DbdTableFields.all()
                        ),
                        new EntriesWithKeys(
                            new EntriesOfYamlMapping(table),
                            DbdTableFields.DESCRIPTION,
                            DbdTableFields.COLUMNS,
                            DbdTableFields.OWNER,
                            DbdTableFields.TABLESPACE,
                            DbdTableFields.PARENT,
                            DbdTableFields.PARTKEYDEFINITION,
                            DbdTableFields.PARTKEYRANGE,
                            DbdTableFields.DEPENDENCIES
                        ),
                        new IterableOf<Map.Entry<? extends Text, ? extends YamlNode>>(
                            new MapEntry<>(
                                DbdTableFields.DATA,
                                new YamlMappingOfScalar(
                                    () -> new SingleOrEmptyFallback<>(
                                        data,
                                        new MapEntry<>(
                                            DbdTableFields.DATA,
                                            new MappingEmpty()
                                        )
                                    ).value().getValue()
                                )
                            ),
                            new MapEntry<>(
                                DbdTableFields.CONSTRAINTS,
                                new YamlMappingOfEntries(constraints)
                            ),
                            new MapEntry<>(
                                DbdTableFields.INDEXES,
                                new YamlMappingOfEntries(indexes)
                            ),
                            new MapEntry<>(
                                DbdTableFields.TRIGGERS,
                                new YamlMappingOfEntries(triggers)
                            )
                        )
                    )
                )
            )
        );
    }

}
