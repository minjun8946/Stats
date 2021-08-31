package com.example.domain.base

enum class Message {
    // network message
    INVALID,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    NOT_ACCEPTABLE,
    CONFLICT,
    PAYLOAD_TOO_LARGE,
    UNKNOWN_ERROR,
    SERVER_ERROR,
    NETWORK_ERROR,

    // search message
    LAST_PAGE
}
