package com.example.verblearn.data.remote.dto

data class VerbsDTO (
    val id: Int?=null,
    var baseForm:String="",
    var pastParticiple:String="",
    var simplePast:String="",
    var definition:String="",

    //spanish
    var spanishBaseForm:String="",
    var spanishPastParticiple:String="",
    var spanishSimplePast:String="",
    var definitionInSpanish:String="",
    var verbProposal:Boolean=false
)