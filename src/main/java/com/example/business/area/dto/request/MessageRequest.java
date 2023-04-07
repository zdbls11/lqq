package com.example.business.area.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MessageRequest {
    @NotNull
    private String message;
}
