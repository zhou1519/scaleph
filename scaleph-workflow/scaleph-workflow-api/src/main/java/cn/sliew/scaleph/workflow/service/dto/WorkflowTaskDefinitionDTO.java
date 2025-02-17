/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.sliew.scaleph.workflow.service.dto;

import cn.sliew.scaleph.common.dict.workflow.WorkflowTaskType;
import cn.sliew.scaleph.common.dto.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class WorkflowTaskDefinitionDTO extends BaseDTO {

    @ApiModelProperty("workflow definition id")
    private Long workflowDefinitionId;

    @ApiModelProperty("workflow task type")
    private WorkflowTaskType type;

    @ApiModelProperty("workflow task name")
    private String name;

    @ApiModelProperty("workflow task handler")
    private String handler;

    @ApiModelProperty("workflow task param")
    private Map<String, Object> param;

    @ApiModelProperty("备注")
    private String remark;

}
