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

package cn.sliew.scaleph.engine.seatunnel.service;

import cn.sliew.scaleph.engine.seatunnel.service.dto.WsDiJobDTO;
import cn.sliew.scaleph.engine.seatunnel.service.vo.DiJobRunVO;
import cn.sliew.scaleph.engine.seatunnel.service.dto.DagPanelDTO;
import cn.sliew.scaleph.plugin.framework.exception.PluginException;
import org.apache.flink.configuration.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Deprecated
public interface SeatunnelJobService {

    String preview(Long jobId) throws Exception;

    void run(DiJobRunVO jobRunParam) throws Exception;

    void submit(WsDiJobDTO wsDiJobDTO) throws Exception;

    void schedule(WsDiJobDTO wsDiJobDTO) throws Exception;

    void stop(Long jobId) throws Exception;

    void cancel(WsDiJobDTO wsDiJobDTO) throws Exception;

    void unschedule(WsDiJobDTO wsDiJobDTO) throws Exception;

    // todo remove
    Path buildConfFile(WsDiJobDTO wsDiJobDTO, Path projectPath) throws Exception;

    Path getSeatunnelJar() throws IOException;

    Configuration buildConfiguration(WsDiJobDTO job, Path seatunnelJarPath,
                                     Map<String, String> clusterConf,
                                     File projectPath) throws IOException;

    List<DagPanelDTO> loadDndPanelInfo() throws PluginException;
}
