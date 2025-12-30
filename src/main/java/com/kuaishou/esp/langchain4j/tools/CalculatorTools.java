package com.kuaishou.esp.langchain4j.tools;

import org.springframework.stereotype.Component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.ToolMemoryId;
import dev.langchain4j.service.MemoryId;

/**
 * @author yanziwei <yanziwei05@kuaishou.com>
 * Created on 2025-12-29
 */
@Component
public class CalculatorTools {

    @Tool(name = "加法", value = "计算两个数的和")
    double sum(
            @ToolMemoryId long memoryId,
            @P(value = "第一个数字", required = true) double arg1, @P(value = "第二个数字", required = true) double arg2
    ) {
        System.out.println("memoryId: " + memoryId + "Calculating sum of " + arg1 + " and " + arg2);
        return arg1 + arg2;
    }

    @Tool(name = "减法", value = "计算两个数的差")
    double subtract(
            @ToolMemoryId long memoryId,
            @P(value = "第一个数字", required = true) double arg1, @P(value = "第二个数字", required = true) double arg2
    ) {
        System.out.println("memoryId: " + memoryId + "Calculating subtraction of " + arg1 + " and " + arg2);
        return arg1 - arg2;
    }

    @Tool(name = "乘法", value = "计算两个数的积")
    double multiply(
            @ToolMemoryId long memoryId,
            @P(value = "第一个数字", required = true) double arg1, @P(value = "第二个数字", required = true) double arg2
    ) {
        System.out.println("memoryId: " + memoryId + "Calculating multiplication of " + arg1 + " and " + arg2);
        return arg1 * arg2;
    }

    @Tool(name = "除法", value = "计算两个数的商")
    double divide(
            @ToolMemoryId long memoryId,
            @P(value = "第一个数字", required = true) double arg1, @P(value = "第二个数字", required = true) double arg2
    ) {
        if (arg2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        System.out.println("memoryId: " + memoryId + "Calculating division of " + arg1 + " by " + arg2);
        return arg1 / arg2;
    }

    @Tool(name = "平方根", value = "计算一个数的平方根")
    double sqrt(
            @ToolMemoryId long memoryId,
            @P(value = "数字", required = true) double arg1
    ) {
        if (arg1 < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        System.out.println("memoryId: " + memoryId + "Calculating square root of " + arg1);
        return Math.sqrt(arg1);
    }
}
