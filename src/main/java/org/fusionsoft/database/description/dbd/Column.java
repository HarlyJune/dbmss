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
package org.fusionsoft.database.description.dbd;

import java.io.IOException;
import java.util.Set;

public interface Column {

    String name() throws IOException;

    String iuColumn() throws IOException;

    String dbName() throws IOException;

    String type() throws IOException;

    boolean nullable() throws IOException;

    String description() throws IOException;

    String dbLocalIdMethod() throws IOException;

    String iuJsonColumn() throws IOException;

    Set<String> iuIncludeProps() throws IOException;

    String dbType() throws IOException;

}
