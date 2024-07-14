package com.aluracursos.forohub.domain.users;

public record UserResponseData(Long id, String username) {
    public UserResponseData(User author) {
        this(author.getId(), author.getUsername());
    }
}
