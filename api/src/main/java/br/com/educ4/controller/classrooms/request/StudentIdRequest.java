package br.com.educ4.controller.classrooms.request;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Setter
@Getter
public class StudentIdRequest {

    private ObjectId studentId;

}
