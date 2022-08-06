package com.obeast.common.utils;

import com.alibaba.excel.EasyExcel;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author wxl
 * @version 1.0
 * @description: EasyExcel工具类
 * @date 2022/8/4 17:06
 */
@Slf4j
public class EasyExcelUtils<T> {

    private final Class<T> clazz;

    public EasyExcelUtils(Class<T> clazz) {
        this.clazz = clazz;
    }

    /**
     * @description: 对list数据源将其里面的数据导入到excel表单
     * @author wxl
     * @date 2022/8/4 17:35
     * @param response 返回数据
     * @param list 导出数据集合
     * @param sheetName 工作表的名称
     * @return 结果
     * @throws IOException
     **/
    public void exportExcel(HttpServletResponse response, List<T> list, String sheetName, String fileName) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8) + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), clazz)
                    .sheet(sheetName)
                    .doWrite(list);
            log.info("导出{}文件成功", URLEncoder.encode(fileName, StandardCharsets.UTF_8) + ".xlsx");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("create excel file failed");
    }

}
