<template>
    <a-modal
        :visible="addHotelModalVisible"
        title="添加酒店"
        cancelText="取消"
        okText="确定"
        @cancel="cancel"
        @ok="handleSubmit"
    >
        <a-form :form="form" style="margin-top: 30px" v-bind="formItemLayout">
            <a-form-item label="酒店名">
                <a-input
                    placeholder="请填写酒店名称"
                    v-decorator="['hotelName', { rules: [{ required: true, message: '请填写酒店名称' }] }]"
                />
            </a-form-item>
            <a-form-item label="酒店地址" v-bind="formItemLayout">
                <a-input
                    placeholder="请填写酒店地址"
                    v-decorator="['address', { rules: [{ required: true, message: '请填写酒店地址' }] }]"
                />
            </a-form-item>
            <a-form-item label="酒店星级" v-bind="formItemLayout">
                <a-select
                    placeholder="请选择酒店星级"
                    v-decorator="[
                    'hotelStar', 
                    { rules: [{ required: true, message: '请选择酒店星级' }] }]"
                    @change="changeStar"
                >
                  <a-select-option value="Three">三星级</a-select-option>
                  <a-select-option value="Four">四星级</a-select-option>
                  <a-select-option value="Five">五星级</a-select-option>
                </a-select>
            </a-form-item>
            <a-form-item label="酒店商圈" v-bind="formItemLayout">
                    <a-select
                            placeholder="请选择酒店商圈"
                            v-decorator="[
                    'bizRegion',
                    { rules: [{ required: true, message: '请选择酒店商圈' }] }]"
                            @change="changeBizRegion"
                    >
                        <a-select-option value="XinJieKou">新街口</a-select-option>
                        <a-select-option value="FuZiMiao">夫子庙</a-select-option>
                        <a-select-option value="AoTiZhongXin">奥体中心</a-select-option>
                        <a-select-option value="JiangNingWanDa">江宁万达</a-select-option>
                        <a-select-option value="XueZeLu">学则路</a-select-option>
                        <a-select-option value="XiDan">西单</a-select-option>
                    </a-select>
            </a-form-item>
            <a-form-item label="酒店电话" v-bind="formItemLayout">
                <a-input
                    placeholder="请填写酒店电话"
                    v-decorator="['phoneNumber', { rules: [{ required: true, message: '请输入酒店电话' }] }]"
                />
            </a-form-item>
            <a-form-item label="酒店简介" v-bind="formItemLayout">
                <a-input
                    type="textarea"
                    :rows="4"
                    placeholder="请填写酒店简介"
                    v-decorator="['description', { rules: [{ required: true, message: '请填写酒店简介' }] }]"
                />
            </a-form-item>
        </a-form>
    </a-modal>
</template>
<script>
import { mapGetters, mapMutations, mapActions } from 'vuex'
export default {
    name: 'addHotelModal',
    data() {
        return {
            formItemLayout: {
                labelCol: {
                    xs: { span: 12 },
                    sm: { span: 6 },
                },
                wrapperCol: {
                    xs: { span: 24 },
                    sm: { span: 16 },
                },
            },
        }
    },
    computed: {
        ...mapGetters([
            'userId',
            'addHotelParams',
            'addHotelModalVisible',
        ])
    },
    beforeCreate() {
        this.form = this.$form.createForm(this, { name: 'addHotelModal' });
    },
    methods: {
        ...mapMutations([
            'set_addHotelParams',
            'set_addHotelModalVisible'
        ]),
        ...mapActions([
            'addHotel'
        ]),
        cancel() {
            this.set_addHotelModalVisible(false)
        },
        changeStar(v){

        },
        changeBizRegion(v){},
        handleSubmit(e) {
            e.preventDefault();
            this.form.validateFieldsAndScroll((err, values) => {
                if (!err) {
                    const data = {
                        name: this.form.getFieldValue('hotelName'),
                        description: this.form.getFieldValue('description'),
                        address: this.form.getFieldValue('address'),
                        phoneNum: this.form.getFieldValue('phoneNumber'),
                        hotelStar: this.form.getFieldValue('hotelStar'),
                        bizRegion: this.form.getFieldValue('bizRegion'),
                        managerId: Number(this.userId),
                    }
                    this.set_addHotelParams(data)
                    this.addHotel()
                }
            });
        },
    }
}
</script>