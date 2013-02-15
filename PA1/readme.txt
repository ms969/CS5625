MJ Sun - ms969
Joey Triska - jdt84

For every material that has specular component, we store it in the GBA 
components of the first material buffer.

For isotropic and anisotropic ward, we store the alphas in the 2nd material 
buffer, and for anisotropic, the encoded tangent goes in the last 2 components 
of the second material buffer.

For the visualizer, the xyz values of the normal, tangent, and bitangents are 
displayed as rgb colors.

We had trouble with anisotropic ward, so it may not compare favorably with the
reference.