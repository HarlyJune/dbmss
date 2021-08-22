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
package org.fusionsoft.lib.collection;

import java.util.Iterator;
import java.util.Map;
import org.cactoos.Proc;
import org.cactoos.iterable.IterableOf;
import org.cactoos.map.MapEnvelope;
import org.cactoos.map.MapOf;
import org.cactoos.scalar.ScalarOf;

public class ValidatedMap<X, Y> extends MapEnvelope<X, Y> {

    /**
     * @param validation The procedure to apply to map before returning `map`
     * @param map        The wrapped map
     */
    public ValidatedMap(final Proc<Map<X, Y>> validation, final Map<X, Y> map) {
        super(
            new MapOf<>(
                new IterableOf<>(
                    new ScalarOf<Iterator<? extends Entry<? extends X, ? extends Y>>>(
                        () -> {
                            validation.exec(map);
                            return map.entrySet().iterator();
                        }
                    )
                )
            )
        );
    }

}
