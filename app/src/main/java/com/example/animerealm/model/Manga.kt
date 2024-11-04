package com.example.animerealm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MangaResponse(
    val pagination: Pagination,
    val data: List<Manga>
) : Parcelable

@Parcelize
data class Pagination(
    val lastVisiblePage: Int,
    val hasNextPage: Boolean,
    val currentPage: Int,
    val items: Items
) : Parcelable

@Parcelize
data class Items(
    val count: Int,
    val total: Int,
    val perPage: Int
) : Parcelable

@Parcelize
data class Manga(
    val malId: Int,
    val url: String,
    val images: Images,
    val approved: Boolean,
    val titles: List<MangaTitle>,
    val title: String,
    val titleEnglish: String?,
    val titleJapanese: String,
    val titleSynonyms: List<String>,
    val type: String,
    val chapters: Int?,
    val volumes: Int?,
    val status: String,
    val publishing: Boolean,
    val published: Published,
    val score: Double,
    val scored: Double,
    val scoredBy: Int,
    val rank: Int?,
    val popularity: Int,
    val members: Int,
    val favorites: Int,
    val synopsis: String,
    val background: String?,
    val authors: List<Author>,
    val serializations: List<Serialization>,
    val genres: List<Genre>,
    val themes: List<Theme>,
    val demographics: List<Demographic>
) : Parcelable

@Parcelize
data class Images(
    val jpg: ImageDetail,
    val webp: ImageDetail
) : Parcelable

@Parcelize
data class ImageDetail(
    val image_url: String,
    val small_image_url: String,
    val large_image_url: String
) : Parcelable

@Parcelize
data class Published(
    val from: String,
    val to: String?,
    val prop: Prop,
    val string: String
) : Parcelable

@Parcelize
data class Prop(
    val from: DateDetails,
    val to: DateDetails?
) : Parcelable

@Parcelize
data class DateDetails(
    val day: Int,
    val month: Int,
    val year: Int
) : Parcelable

@Parcelize
data class Author(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Serialization(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Genre(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Theme(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class Demographic(
    val malId: Int,
    val type: String,
    val name: String,
    val url: String
) : Parcelable

@Parcelize
data class MangaTitle(
    val type: String,
    val title: String
) : Parcelable
