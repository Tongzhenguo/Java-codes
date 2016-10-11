# coderepos
平时积累的java代码做成一个库

Normalization 是常见的数据标准化方法

对数似然率相似度：
    我以一个实际的例子来介绍一下其中的计算过程：假设有商品全集I=｛a,b,c,d,e,f｝，其中A用户偏好商品{a,b,c}，B用户偏好商品{b,d}，那么有如下矩阵：
    ----|------
    1   |   2
    1   |   2
    ----|-----
    k11表示用户A和用户B的共同偏好的商品数量，显然只有商品b，因此值为1
    k12表示用户A的特有偏好，即商品{a,c}，因此值为2
    k21表示用户B的特有偏好，即商品d，因此值为1
    k22表示用户A、B的共同非偏好，有商品{e,f}，值为2
    此外我们还定义以下变量N=k11+k12+k21+k22，即总商品数量。

    计算步骤如下：
    计算行熵
    rowEntropy=k11+k12N(k11k11+k12logk11k11+k12+k12k11+k12logk12k11+k12)+k21+k22N(k21k21+k22logk21k21+k22+k22k21+k22logk22k21+k22)
    注：代码中k11+k12与k21+k22均被约掉了，分母N也省去了

    计算列熵
    columEntropy=k11+k21N(k11k11+k21logk11k11+k21+k21k11+k21logk21k11+k21)+k12+k22N(k12k12+k22logk12k12+k22+k22k12+k22logk22k12+k22)

    计算矩阵熵
    matrixEntropy=k11Nlogk11N+k12Nlogk12N+k21Nlogk21N+k22Nlogk22N

    注意：以上熵的计算均没有加负号
    计算相似度

    UserSimilarity=2∗(matrixEntropy−rowEntropy−columnEntropy)