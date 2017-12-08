package com.example.cpu10225.kotlinonandroid.data.network

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by cpu10225 on 05/12/2017.
 */

data class RedditNewsItem (
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readLong(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(author)
        writeString(title)
        writeInt(num_comments)
        writeLong(created)
        writeString(thumbnail)
        writeString(url)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RedditNewsItem> = object : Parcelable.Creator<RedditNewsItem> {
            override fun createFromParcel(source: Parcel): RedditNewsItem = RedditNewsItem(source)
            override fun newArray(size: Int): Array<RedditNewsItem?> = arrayOfNulls(size)
        }
    }
}

data class RedditNews(
        val after: String,
        val before: String,
        val children: List<Children>) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            ArrayList<Children>().apply { source.readList(this, Children::class.java.classLoader) }
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(after)
        writeString(before)
        writeList(children)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RedditNews> = object : Parcelable.Creator<RedditNews> {
            override fun createFromParcel(source: Parcel): RedditNews = RedditNews(source)
            override fun newArray(size: Int): Array<RedditNews?> = arrayOfNulls(size)
        }
    }
}

data class News(
    @SerializedName("kind")
    @Expose
    private val kind: String? = null,
    @SerializedName("data")
    @Expose
    private val data: RedditNews? = null
)

data class Children(
    @SerializedName("kind")
    @Expose
    private val kind: String? = null,
    @SerializedName("data")
    @Expose
    private val data: RedditNewsItem? = null)