package com.sierra.vagabond.data.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sierra.vagabond.utils.START_DATE
import com.sierra.vagabond.utils.WATCH_FACILITY_ID
import com.sierra.vagabond.utils.WATCH_FACILITY_NAME
import com.sierra.vagabond.utils.WATCH_TOKEN

data class WatchRequest(@field:SerializedName(WATCH_FACILITY_ID) @field:Expose val facilityId: String,
                        @field:SerializedName(WATCH_FACILITY_NAME) @field:Expose val facilityName: String,
                        @field:SerializedName(START_DATE) @field:Expose val startDate: Long,
                        @field:SerializedName(WATCH_TOKEN) @field:Expose val watchToken: String?)