package com.example.newtest.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? =0,
    @ColumnInfo(name = "section")
    var section: String? = null,
    @ColumnInfo(name = "subsection")
    var subsection: String? = null,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "abstract")
    var abstract: String? = null,
    @ColumnInfo(name = "url")
    var url: String? = null,
    @ColumnInfo(name = "byline")
    var byline: String? = null,
    @ColumnInfo(name = "item_type")
    var itemType: String? = null,
    @ColumnInfo(name = "updated_date")
    var updatedDate: String? = null,
    @ColumnInfo(name = "created_date")
    var createdDate: String? = null,
    @ColumnInfo(name = "published_date")
    var publishedDate: String? = null,
    @ColumnInfo(name = "material_type_facet")
    var materialTypeFacet: String? = null,
    @ColumnInfo(name = "kicker")
    var kicker: String? = null,
    @ColumnInfo(name = "des_facet")
    var desFacet: List<String>? = null,
    @ColumnInfo(name = "org_facet")
    var orgFacet: List<String>? = null,
    @ColumnInfo(name = "per_facet")
    var perFacet: List<String>? = null,
    @ColumnInfo(name = "geo_facet")
    var geoFacet: List<String>? = null,
    @ColumnInfo(name = "multimedia")
    var multimedia: List<Multimedia>? = null,
    @ColumnInfo(name = "short_url")
    var shortUrl: String? = null
)
