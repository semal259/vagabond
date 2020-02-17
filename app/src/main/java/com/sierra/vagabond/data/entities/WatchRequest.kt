package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.*
import java.time.Instant

data class WatchRequest(@field:SerializedName(WATCH_ID) @field:Expose val watchId: String? = null,
                        @field:SerializedName(USER_WATCH_ID) @field:Expose val userId: String,
                        @field:SerializedName(WATCH_FACILITY_ID) @field:Expose val facilityId: String,
                        @field:SerializedName(WATCH_FACILITY_NAME) @field:Expose val facilityName: String,
                        @field:SerializedName(START_DATE) @field:Expose val startDate: String?,
                        @field:SerializedName(END_DATE) @field:Expose val endDate: String?)