import {NsGraph} from "@antv/xflow";
import {ModalFormProps} from '@/app.d';
import {WsDiJobService} from "@/services/project/WsDiJob.service";
import {Form, message, Modal} from "antd";
import {WsDiJob} from "@/services/project/typings";
import {getIntl, getLocale} from "umi";
import {ProForm, ProFormText} from "@ant-design/pro-components";
import {useEffect} from "react";
import {STEP_ATTR_TYPE} from "@/pages/Project/Workspace/Job/DI/DiJobFlow/Dag/constant";

const StepForm: React.FC<ModalFormProps<{
  node: NsGraph.INodeConfig;
  graphData: NsGraph.IGraphData;
  graphMeta: NsGraph.IGraphMeta;
}>> = ({data, visible, onCancel, onOK}) => {
  const nodeInfo = data.node.data;
  const jobInfo = data.graphMeta.origin as WsDiJob;
  const jobGraph = data.graphData;
  const intl = getIntl(getLocale(), true);
  const [form] = Form.useForm();

  useEffect(() => {
    form.setFieldValue(STEP_ATTR_TYPE.stepTitle, nodeInfo.label);
  }, []);

  return (<Modal
    open={visible}
    title={nodeInfo.data.displayName}
    width={780}
    bodyStyle={{overflowY: 'scroll', maxHeight: '640px'}}
    destroyOnClose={true}
    onCancel={onCancel}
    onOk={() => {
      form.validateFields().then((values) => {
        let map: Map<string, string> = new Map();
        map.set(STEP_ATTR_TYPE.jobId, jobInfo.id + '');
        map.set(STEP_ATTR_TYPE.jobGraph, JSON.stringify(jobGraph));
        map.set(STEP_ATTR_TYPE.stepCode, nodeInfo.id);
        map.set(STEP_ATTR_TYPE.stepTitle, values[STEP_ATTR_TYPE.stepTitle]);
        map.set(STEP_ATTR_TYPE.stepAttrs, form.getFieldsValue());
        WsDiJobService.saveStepAttr(map).then((resp) => {
          if (resp.success) {
            message.success(intl.formatMessage({id: 'app.common.operate.success'}));
            onCancel();
            onOK ? onOK(values) : null;
          }
        });
      });
    }}
  >
    <ProForm form={form} initialValues={nodeInfo.data.attrs} grid={true} submitter={false}>
      <ProFormText
        name={STEP_ATTR_TYPE.stepTitle}
        label={intl.formatMessage({id: 'pages.project.di.step.stepTitle'})}
        rules={[{required: true}, {max: 120}]}
      />

    </ProForm>
  </Modal>);
}

export default StepForm;
