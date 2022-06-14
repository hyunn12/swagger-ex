package com.example.swagger;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Api(tags = {"1. Test"})
@RestController
@RequestMapping(value = "/v1/api")
public class TestController {

    @GetMapping(value = "/hello")
    @ApiOperation(value = "hello, world api", notes = "hello world swagger check")
    public String helloWorld(){
        return "hello, world";
    }

    @ApiOperation(value = "test", notes = "테스트입니다")
    @ApiResponses({@ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "page not found!")})
    @GetMapping(value = "/board")
    public Map<String, String> selectBoard(@ApiParam(value = "샘플번호", required = true, example = "1")
                                           @RequestParam String no) {

        Map<String, String> result = new HashMap<>();
        result.put("test title", "테스트");
        result.put("test contents", "테스트 내용");
        return result;
    }

}
