/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.hive;

import com.facebook.presto.spi.ErrorCode;
import com.facebook.presto.spi.ErrorCodeSupplier;

public enum HiveErrorCode
        implements ErrorCodeSupplier
{
    HIVE_METASTORE_ERROR(0),
    HIVE_CURSOR_ERROR(1),
    HIVE_TABLE_OFFLINE(2),
    HIVE_CANNOT_OPEN_SPLIT(3),
    HIVE_FILE_NOT_FOUND(4),
    HIVE_UNKNOWN_ERROR(5),
    HIVE_PARTITION_OFFLINE(6),
    HIVE_BAD_DATA(7),
    HIVE_PARTITION_SCHEMA_MISMATCH(8),
    HIVE_MISSING_DATA(9),
    HIVE_INVALID_PARTITION_VALUE(10),
    HIVE_TIMEZONE_MISMATCH(11),
    HIVE_INVALID_METADATA(12),
    HIVE_INVALID_VIEW_DATA(13),
    HIVE_DATABASE_LOCATION_ERROR(14),
    HIVE_PATH_ALREADY_EXISTS(15),
    HIVE_FILESYSTEM_ERROR(16),
    // code HIVE_WRITER_ERROR(17) is deprecated
    HIVE_SERDE_NOT_FOUND(18),
    HIVE_UNSUPPORTED_FORMAT(19),
    HIVE_PARTITION_READ_ONLY(20),
    HIVE_TOO_MANY_OPEN_PARTITIONS(21),
    HIVE_CONCURRENT_MODIFICATION_DETECTED(22),
    HIVE_COLUMN_ORDER_MISMATCH(23),
    HIVE_FILE_MISSING_COLUMN_NAMES(24),
    HIVE_WRITER_OPEN_ERROR(25),
    HIVE_WRITER_CLOSE_ERROR(26),
    HIVE_WRITER_DATA_ERROR(27);

    private final ErrorCode errorCode;

    HiveErrorCode(int code)
    {
        errorCode = new ErrorCode(code + 0x0100_0000, name());
    }

    @Override
    public ErrorCode toErrorCode()
    {
        return errorCode;
    }
}
