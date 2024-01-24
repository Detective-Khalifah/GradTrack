package com.blogspot.thengnet.data

//data class StatesAndLocalGovernmentAreas()

data class State(
    val code: String,
    val name: String,
    val capitalCity: String,
    val nicknames: List<String>,
    val localGovernmentAreas: List<LocalGovernmentArea>
) {
    override fun toString(): String {
        return name
    }
}

data class LocalGovernmentArea(
    val code: String,
    val name: String
)

data class States(
    val states: List<State>
)
