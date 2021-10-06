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
package org.fusionsoft.database.snapshot.objects;

import com.amihaiemil.eoyaml.YamlMapping;
import com.amihaiemil.eoyaml.YamlNode;
import org.cactoos.Text;
import org.cactoos.iterable.IterableEnvelope;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.iterator.IteratorOf;
import org.cactoos.set.SetOf;
import org.cactoos.text.TextOfScalar;
import org.fusionsoft.database.snapshot.DbObject;
import org.fusionsoft.database.snapshot.NaiveDbObject;
import org.fusionsoft.database.snapshot.ObjectType;
import org.fusionsoft.database.snapshot.Objects;
import org.fusionsoft.database.snapshot.objectsignature.NaiveObjectSignature;
import org.fusionsoft.lib.yaml.YamlMappingOfScalar;
import org.fusionsoft.lib.yaml.artefacts.MappingFromMappingIgnoreKeys;

/**
 * The type of Objects of dbd schema mapping.
 * @since 0.1
 */
public class ObjectsOfDbdSchemaMapping extends IterableEnvelope<DbObject> implements Objects {

    /**
     * Instantiates a new Objects of dbd schema mapping.
     * @param parent The YamlMapping to be encapsulated.
     * @param key The YamlNode to be encapsulated.
     */
    public ObjectsOfDbdSchemaMapping(
        final YamlMapping parent,
        final YamlNode key
    ) {
        this(
            new YamlMappingOfScalar(() -> parent.value(key).asMapping()),
            new TextOfScalar(() -> key.asScalar().value())
        );
    }

    /**
     * Instantiates a new Objects of dbd schema mapping.
     * @param mapping The YamlMapping to be encapsulated.
     * @param key The Text to be encapsulated.
     */
    public ObjectsOfDbdSchemaMapping(
        final YamlMapping mapping,
        final Text key
    ) {
        super(
            new Joined<>(
                new NaiveDbObject(
                    new MappingFromMappingIgnoreKeys(
                        mapping,
                        new SetOf<String>("tables")
                    ),
                    new NaiveObjectSignature(key, ObjectType.SCHEMA)
                ),
                new IterableOf<DbObject>(
                    () -> {
                        return new IteratorOf<DbObject>();
                    }
                )
            )
        );
    }

}
