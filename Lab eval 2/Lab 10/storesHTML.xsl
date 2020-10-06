<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="gadgetList">

    <xsl:for-each select="brandWise">
        
        <h3>Brand: <xsl:value-of select="@brand"></xsl:value-of></h3>

        

            <xsl:for-each select="productDetails">
                <div style="display:inline-block;width:25%;margin-left:6%;vertical-align:top;">

                    <h3><xsl:value-of select="name"></xsl:value-of> </h3>
                    <h4><xsl:value-of select="color"></xsl:value-of></h4>
            
                    <h4><xsl:value-of select="price"></xsl:value-of></h4>
                    <h5><xsl:value-of select="xchngPrice"></xsl:value-of></h5>
            

                </div>
            
               

            



        
        
        
        
    </xsl:for-each>
    <hr/>

    </xsl:for-each>



</xsl:template>

<xsl:output method="html" version="1.0"
encoding="UTF-8" indent="yes"/>

</xsl:stylesheet>