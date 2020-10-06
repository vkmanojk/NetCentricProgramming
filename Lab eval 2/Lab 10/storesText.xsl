<?xml version="1.0" encoding="UTF-8"?>

<xsl:transform version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="gadgetList">

    <xsl:for-each select="brandWise">
        
         <xsl:value-of select="@brand"></xsl:value-of> ....        

            <xsl:for-each select="productDetails">
                
                <xsl:value-of select="name"></xsl:value-of> ,
                <xsl:value-of select="color"></xsl:value-of> ,            
                <xsl:value-of select="price"></xsl:value-of> ,
                <xsl:value-of select="xchngPrice"></xsl:value-of>
            -------------------------------------------------------------    
        
            </xsl:for-each>
    xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    

    </xsl:for-each>



</xsl:template>

<xsl:output method="text" version="1.0"
encoding="UTF-8" indent="yes"/>

</xsl:transform>