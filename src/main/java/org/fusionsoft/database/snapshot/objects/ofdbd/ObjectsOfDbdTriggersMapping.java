/*
 * Copyright (C) 2018-2022 FusionSoft
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
package org.fusionsoft.database.snapshot.objects.ofdbd;

import com.amihaiemil.eoyaml.YamlMapping;
import org.cactoos.Text;
import org.fusionsoft.database.mapping.dbd.DbdTriggerMapping;
import org.fusionsoft.database.snapshot.objects.ObjectsEnvelope;
import org.fusionsoft.database.snapshot.objects.signature.ObjectName;
import org.fusionsoft.lib.yaml.YamlMappingOfPath;
import org.fusionsoft.lib.yaml.YamlMappingOrEmptyWhenNoValueNotFound;
import org.fusionsoft.lib.yaml.artefacts.IterableOfClassFromYamlNode;

/**
 * The objects of {@link DbdTriggerMapping}, extracted of DBD/schemas/#schema/triggers node.
 * @since 0.1
 */
public class ObjectsOfDbdTriggersMapping extends ObjectsEnvelope<DbdTriggerMapping> {

    /**
     * Instantiates a new Objects of dbd triggers mapping.
     * @param mapping The {@link YamlMapping} to be encapsulated.
     * @param key The {@link Text} to be encapsulated.
     * @param table The {@link ObjectName} to be encapsulated.
     */
    public ObjectsOfDbdTriggersMapping(
        final YamlMapping mapping,
        final Text key,
        final ObjectName table
    ) {
        this(
            new YamlMappingOrEmptyWhenNoValueNotFound(
                new YamlMappingOfPath(mapping, key)
            ),
            table
        );
    }

    /**
     * Instantiates a new Objects of dbd triggers mapping.
     * @param mapping The {@link YamlMapping} to be encapsulated.
     * @param table The {@link ObjectName} to be encapsulated.
     */
    public ObjectsOfDbdTriggersMapping(final YamlMapping mapping, final ObjectName table) {
        super(
            new IterableOfClassFromYamlNode<>(
                (map, node) -> new TriggerOfDbdMapping(map, node, table),
                mapping
            )
        );
    }

}
