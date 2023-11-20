package ucc.analisis.sistemas.m3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ObjectResponse<T> {
    private Integer code;
    private String msg;
    private List<T> list;
    private Object object;
}
