Ext.define('TTT.model.Company', {
    extend: 'Ext.data.Model',
    
    fields: [
             
        { name: 'companyId', type: 'int', useNull:true  },
        { name: 'companyName', type: 'string' }

    ]
});
