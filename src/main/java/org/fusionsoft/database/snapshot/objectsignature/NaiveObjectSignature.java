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
package org.fusionsoft.database.snapshot.objectsignature;

import java.text.MessageFormat;
import org.cactoos.Text;
import org.fusionsoft.database.snapshot.ObjectSignature;
import org.fusionsoft.database.snapshot.ObjectType;

/**
 * The base {@link ObjectSignature} implementation.
 * @since 0.1
 */
public class NaiveObjectSignature implements ObjectSignature {

    /**
     * The Text encapsulated.
     */
    private final Text nam;

    /**
     * The ObjectType encapsulated.
     */
    private final ObjectType typ;

    /**
     * Instantiates a new Object signature of.
     * @param name The Text to be encapsulated.
     * @param type The ObjectType to be encapsulated.
     */
    public NaiveObjectSignature(final Text name, final ObjectType type) {
        this.nam = name;
        this.typ = type;
    }

    @Override
    public final Text name() {
        return this.nam;
    }

    @Override
    public final ObjectType type() {
        return this.typ;
    }

    @Override
    public final String asString() throws Exception {
        return MessageFormat.format(
            "{0}.{1}",
            this.name().asString(),
            this.type().asString()
        );
    }

}
