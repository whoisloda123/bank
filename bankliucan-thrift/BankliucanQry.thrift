/**
* �ļ���ΪBankliucanQry.thrift
* ʵ�ֹ��ܣ�����һ����ѯ���struct��һ������ӿ�service
* ���ڣ�thrift-0.9.2
**/
namespace java com.thrift
struct AccountResult {
        /**
        *������, 1�ɹ���0ʧ��
        */
        1:i32 code;
        /**
        *��Ӧ��Ϣ
        */
        2:string msg;
}
service BankliucanQry{
        /**
        * ����accountid��ѯ�û���account���ɹ�������ʧ�ܷ���ʧ����Ϣ
        * @param accountid�˺�id
        */
        AccountResult serachMoneyByAccountId(1:i32 accountId)
}