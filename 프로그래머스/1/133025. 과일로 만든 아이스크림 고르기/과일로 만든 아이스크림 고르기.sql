-- 코드를 입력하세요
SELECT FH.FLAVOR
FROM FIRST_HALF FH
WHERE FH.TOTAL_ORDER > 3000 AND (SELECT II.INGREDIENT_TYPE
                                FROM ICECREAM_INFO II
                                WHERE II.FLAVOR = FH.FLAVOR) = "fruit_based";
