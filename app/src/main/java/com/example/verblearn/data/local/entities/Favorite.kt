package com.example.verblearn.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.verblearn.data.remote.dto.VerbsDTO

@Entity(tableName = "Favorites")
data class Favorite (
    @PrimaryKey
    val id:Int?=null,
    var baseForm:String="",
    var pastParticiple:String="",
    var simplePast:String="",
    var definition:String="",

    //spanish
    var spanishBaseForm:String="",
    var spanishPastParticiple:String="",
    var spanishSimplePast:String="",
    var definitionInSpanish:String="",
    var verbProposal:Boolean=false,

    var isFavorite:Boolean=false
)