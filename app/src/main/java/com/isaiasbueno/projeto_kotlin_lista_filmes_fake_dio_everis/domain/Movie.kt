package com.isaiasbueno.projeto_kotlin_lista_filmes_fake_dio_everis.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val imagem: String?,
    val descricao: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?
): Parcelable