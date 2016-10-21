# coderepos
平时积累的java代码做成一个库

Normalization 是常见的数据标准化方法

对数似然率相似度： 
    计算步骤如下：
    计算行熵
    计算列熵
    计算矩阵熵
    matrixEntropy=k11Nlogk11N+k12Nlogk12N+k21Nlogk21N+k22Nlogk22N
    注意：以上熵的计算均没有加负号
    计算相似度
    UserSimilarity=2∗(matrixEntropy−rowEntropy−columnEntropy)
    
redis缓存，解决mysql查询压力过大

