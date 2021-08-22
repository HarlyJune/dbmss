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
 *
 */
package org.fusionsoft.database.condition;

import java.util.Collection;
import org.cactoos.iterable.Mapped;
import org.cactoos.scalar.And;
import org.fusionsoft.database.DbObject;
import org.fusionsoft.database.DbmsSignature;

public class EachDboHasDbmsSignature extends ConditionEnvelope {

    public EachDboHasDbmsSignature(final DbmsSignature dbmsSignature, final Collection<DbObject> dbObjectCollection) {
        super(
            new And(
                new Mapped<>(
                    x -> new DboHasDbmsSignature(dbmsSignature, x),
                    dbObjectCollection
                )
            )
        );
    }

}
