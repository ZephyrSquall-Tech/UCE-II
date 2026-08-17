/**
 * 粒子注册:敲击火花、气体闪现粒子(设计文档 §13.3.9,按气体标识色)、开放空间烟柱、浓缩机光效等。
 * <p>并发预算 ≤768(常规 512 + 烟柱 256,开发流程文档 §七);
 * 聚集类 {@link com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles.ModParticles}。</p>
 */
package com.zeqhyrsquall.uraniumcontaminationeraii.core.registry.particles;
