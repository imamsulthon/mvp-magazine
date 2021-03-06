package taiwan.no1.app.mvp.models

import android.os.Parcel
import android.os.Parcelable
import taiwan.no1.app.ui.adapter.viewholder.viewtype.IViewTypeFactory

/**
 * @author  Jieyi
 * @since   12/29/16
 */

data class FilmCastsModel(val cast: List<CastBean>? = null,
                          val crew: List<CrewBean>? = null): Parcelable {
    data class CastBean(val cast_id: Int = 0,
                        val character: String? = null,
                        val credit_id: String? = null,
                        val id: Int = 0,
                        val name: String? = null,
                        val order: Int = 0,
                        val profile_path: String? = null): IVisitable, Parcelable {
        override fun type(typeFactory: IViewTypeFactory): Int = typeFactory.type(this)

        //region Parcelable
        companion object {
            @JvmField val CREATOR: Parcelable.Creator<CastBean> = object: Parcelable.Creator<CastBean> {
                override fun createFromParcel(source: Parcel): CastBean = CastBean(source)
                override fun newArray(size: Int): Array<CastBean?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel): this(source.readInt(),
                source.readString(),
                source.readString(),
                source.readInt(),
                source.readString(),
                source.readInt(),
                source.readString())

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel?, flags: Int) {
            dest?.writeInt(cast_id)
            dest?.writeString(character)
            dest?.writeString(credit_id)
            dest?.writeInt(id)
            dest?.writeString(name)
            dest?.writeInt(order)
            dest?.writeString(profile_path)
        }
        //endregion
    }

    data class CrewBean(val credit_id: String? = null,
                        val department: String? = null,
                        val id: Int = 0,
                        val job: String? = null,
                        val name: String? = null,
                        val profile_path: String? = null): IVisitable, Parcelable {
        override fun type(typeFactory: IViewTypeFactory): Int = typeFactory.type(this)

        //region Parcelable
        companion object {
            @JvmField val CREATOR: Parcelable.Creator<CrewBean> = object: Parcelable.Creator<CrewBean> {
                override fun createFromParcel(source: Parcel): CrewBean = CrewBean(source)
                override fun newArray(size: Int): Array<CrewBean?> = arrayOfNulls(size)
            }
        }

        constructor(source: Parcel): this(source.readString(),
                source.readString(),
                source.readInt(),
                source.readString(),
                source.readString(),
                source.readString())

        override fun describeContents() = 0

        override fun writeToParcel(dest: Parcel?, flags: Int) {
            dest?.writeString(credit_id)
            dest?.writeString(department)
            dest?.writeInt(id)
            dest?.writeString(job)
            dest?.writeString(name)
            dest?.writeString(profile_path)
        }
        //endregion
    }

    //region Parcelable
    companion object {
        @JvmField val CREATOR: Parcelable.Creator<FilmCastsModel> = object: Parcelable.Creator<FilmCastsModel> {
            override fun createFromParcel(source: Parcel): FilmCastsModel = FilmCastsModel(source)
            override fun newArray(size: Int): Array<FilmCastsModel?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel): this(source.createTypedArrayList(CastBean.CREATOR),
            source.createTypedArrayList(CrewBean.CREATOR))

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest?.writeTypedList(cast)
        dest?.writeTypedList(crew)
    }
    //endregion
}

